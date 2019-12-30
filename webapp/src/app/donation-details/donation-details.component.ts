import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { BloodGroup } from '../search/blood-group.model';
import { State } from '../search/state.model';
import { SearchService } from '../search/search.service';
import { Area } from '../search/area.model';
import { City } from '../search/city.model';
import { DonationDetailsService } from './donation-details.service';
import { Router } from '@angular/router';
import { UserAuthService } from '../user-auth.service';
import { User } from '../home/user.model';

@Component({
  selector: 'app-donation-details',
  templateUrl: './donation-details.component.html',
  styleUrls: ['./donation-details.component.css']
})
export class DonationDetailsComponent implements OnInit {
  donationForm: FormGroup;
  error: string;
  bloodGroupList: BloodGroup[];
  statesList: State[];
  citiesList: City[];
  areaList: Area[];
  stateSelected = false;
  citySelected = false;
  success=false;
  user:User;
  constructor(private searchService:SearchService,private donationDetailsService:DonationDetailsService,private router:Router,private userAuthService:UserAuthService) { }

  ngOnInit() {
    this.donationForm = new FormGroup({
      "user":new FormControl(this.userAuthService.getUserDetails()),
      "bloodGroup": new FormControl(null, Validators.required),
      "units": new FormControl(null, [Validators.required,Validators.max(2)]),
      "state": new FormControl(null,Validators.required),
      "city": new FormControl(null, Validators.required),
      "area": new FormControl(null, Validators.required),
      "contactNumber": new FormControl(null, [Validators.required,Validators.maxLength(10)])
    })
    this.searchService.getAllBloodGroups().subscribe(bloodGroups => {
      this.bloodGroupList = bloodGroups;
    });
    this.searchService.getAllStates().subscribe(states => {
      this.statesList = states;
    })
  }
  getCities() {
    this.searchService.getAllCitiesByStateId(this.donationForm.value.state.id).subscribe(cities => {
      this.stateSelected = true;
      console.log(cities);
      this.citiesList = cities;
    })
  }
  getAreas() {
    this.searchService.getAllAreasByCityId(this.donationForm.value.city.id).subscribe(areas => {
      this.citySelected = true;
      console.log(areas);
      this.areaList = areas;
    })
  }
  onSubmit(){  
    this.donationDetailsService.addDonationDetails(this.donationForm.value);
      this.router.navigate(["/donorSlotDetails",this.donationForm.value.area.id]);
  }
}
