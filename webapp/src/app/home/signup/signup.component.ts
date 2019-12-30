import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/user.service';
import { Observable } from 'rxjs';
import { SearchService } from 'src/app/search/search.service';
import { BloodGroup } from 'src/app/search/blood-group.model';
import { State } from 'src/app/search/state.model';
import { City } from 'src/app/search/city.model';
import { Area } from 'src/app/search/area.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signUpForm:FormGroup;
  error:string;
  formSubmitted:boolean;
  bloodGroupList:BloodGroup[];
  statesList:State[];
  citiesList:City[];
  areaList:Area[]
  userAlreadyExists=false;
  stateSelected=false;
  citySelected=false;
 
  constructor(private router:Router,private userService:UserService,private searchService:SearchService) { }

  ngOnInit() {
    this.signUpForm = new FormGroup({
      "username": new FormControl(null, [Validators.required, Validators.maxLength(20),Validators.pattern("^[a-zA-Z]+$")],this.isUserNameTaken),
      "firstName": new FormControl(null, [Validators.required, Validators.maxLength(50),Validators.pattern("^[a-zA-Z ]+$")]),
      "lastName": new FormControl(null, [Validators.required, Validators.maxLength(50),Validators.pattern("^[a-zA-Z ]+$")]),
      "age": new FormControl(null, [Validators.required,Validators.pattern("^[0-9]+$"),Validators.maxLength(2)]),
      "gender": new FormControl(null, Validators.required),
      "contactNumber": new FormControl(null, [Validators.required,Validators.pattern("^[0-9]+$"), Validators.maxLength(10)]),
      "email": new FormControl(null, [Validators.required,Validators.email]),
      "password": new FormControl(null, [Validators.required, Validators.maxLength(10)]),
      "confirmPassword": new FormControl(null, [Validators.required, Validators.maxLength(10), this.matchConfirmPassword.bind(this)]),
      "weight": new FormControl(null, [Validators.required,Validators.pattern("^[0-9]+$")]),
      "state": new FormControl(null, Validators.required),
      "city": new FormControl(null, Validators.required),
      "area": new FormControl(null, Validators.required),
      "pincode": new FormControl(null, [Validators.required,Validators.pattern("^[0-9]+$"),Validators.maxLength(6)]),
      "bloodGroup": new FormControl(null, Validators.required)
      });
      this.searchService.getAllBloodGroups().subscribe(bloodGroups => {
        this.bloodGroupList = bloodGroups;
      });
      this.searchService.getAllStates().subscribe(states => {
        this.statesList = states;
      })
  }
  isUserNameTaken(formControl: FormControl): Promise<any> | Observable<any> {
    const promise = new Promise((resolve, reject) => {
      setTimeout(() => {
        if (formControl.value === "john") {
          resolve({ "userTaken": true });
        }
        else {
          resolve(null);
        }
      }, 2000);
    });
    return promise;
  }
  onSubmitSignUp(){
    console.log(this.signUpForm.value);
    this.userService.addUser(this.signUpForm.value).subscribe((data) => {
      this.router.navigate(['/login']);
    },
      error => {
        this.error = error.message;
        console.log(error);
        this.userAlreadyExists=true;
      });
      this.formSubmitted = true;
      this.signUpForm.reset();
  }
  matchConfirmPassword(formControl: FormControl): {} {
    if (this.signUpForm) {
      if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get("password").value) {
        return { "nomatch": true };
      }
    }
    return null;
  }
  getCities() {
    this.searchService.getAllCitiesByStateId(this.signUpForm.value.state.id).subscribe(cities => {
      this.stateSelected = true;
      console.log(cities);
      this.citiesList = cities;
    })
  }
  getAreas() {
    this.searchService.getAllAreasByCityId(this.signUpForm.value.city.id).subscribe(areas => {
      this.citySelected = true;
      console.log(areas);
      this.areaList = areas;
    })
  }

}
