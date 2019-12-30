import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { BloodGroup } from '../search/blood-group.model';
import { State } from '../search/state.model';
import { City } from '../search/city.model';
import { Area } from '../search/area.model';
import { User } from '../home/user.model';
import { SearchService } from '../search/search.service';
import { DonationDetailsService } from '../donation-details/donation-details.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserAuthService } from '../user-auth.service';
import { RequestPostingService } from './request-posting.service';

@Component({
  selector: 'app-request-posting',
  templateUrl: './request-posting.component.html',
  styleUrls: ['./request-posting.component.css']
})
export class RequestPostingComponent implements OnInit {
  requestForm: FormGroup;
  error: string;
  bloodGroupList: BloodGroup[];
  statesList: State[];
  citiesList: City[];
  areaList: Area[];
  stateSelected = false;
  citySelected = false;
  user: User;
  constructor(private searchService: SearchService, private route: ActivatedRoute, private userAuthService: UserAuthService, private requestPostingService: RequestPostingService, private router: Router) { }

  ngOnInit() {
    this.route.data.subscribe(data => {
      console.log(data);
      this.requestForm = new FormGroup({
        "user": new FormControl(this.userAuthService.getUserDetails()),
        "bloodGroup": new FormControl(data.bloodGroup, Validators.required),
        "units": new FormControl(null, Validators.required),
        "state": new FormControl(data.state, Validators.required),
        "city": new FormControl(data.city, Validators.required),
        "area": new FormControl(data.area, Validators.required),
        "contactNumber": new FormControl(null, [Validators.required, Validators.maxLength(10)])
      })
    })
    this.searchService.getAllBloodGroups().subscribe(bloodGroups => {
      this.bloodGroupList = bloodGroups;
    });
    this.searchService.getAllStates().subscribe(states => {
      this.statesList = states;
    })

  }
  getCities() {
    this.searchService.getAllCitiesByStateId(this.requestForm.value.state.id).subscribe(cities => {
      this.stateSelected = true;
      console.log(cities);
      this.citiesList = cities;
    })
  }
  getAreas() {
    this.searchService.getAllAreasByCityId(this.requestForm.value.city.id).subscribe(areas => {
      this.citySelected = true;
      console.log(areas);
      this.areaList = areas;
    })
  }
  onSubmit() {
    this.requestPostingService.addRequestPostingDetails(this.requestForm.value).subscribe(data => {
      this.router.navigate(["/"]);
    })
  }

}
