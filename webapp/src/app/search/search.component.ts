import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { BloodGroup } from './blood-group.model';
import { SearchService } from './search.service';
import { State } from './state.model';
import { City } from './city.model';
import { Area } from './area.model';
import { DonationDetails } from './donation-details.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchForm: FormGroup;
  error: string;
  bloodGroupList: BloodGroup[];
  statesList: State[];
  citiesList: City[];
  areaList: Area[];
  donarDetails:DonationDetails[];
  stateSelected = false;
  citySelected = false;
  searched=false;
  noDonarDetails=false;
  constructor(private searchService: SearchService,private router:Router) {

  }

  ngOnInit() {
    this.searchForm = new FormGroup({
      "bloodGroup": new FormControl(null, Validators.required),
      "state": new FormControl(null, Validators.required),
      "city": new FormControl(null, Validators.required),
      "area": new FormControl(null, Validators.required)
    })
    this.searchService.getAllBloodGroups().subscribe(bloodGroups => {
      this.bloodGroupList = bloodGroups;
    });
    this.searchService.getAllStates().subscribe(states => {
      this.statesList = states;
    })
  }
  getCities() {
    this.searchService.getAllCitiesByStateId(this.searchForm.value.state.id).subscribe(cities => {
      this.stateSelected = true;
      console.log(cities);
      this.citiesList = cities;
    })
  }
  getAreas() {
    this.searchService.getAllAreasByCityId(this.searchForm.value.city.id).subscribe(areas => {
      this.citySelected = true;
      console.log(areas);
      this.areaList = areas;
    })
  }
  onSearch() {
    this.searched=true;
    let route=this.router.config.find(r=>r.path==="requestPosting")
    route.data=this.searchForm.value;
    this.searchService.getAllDonationDetails(this.searchForm.value.state.id, this.searchForm.value.city.id, 
      this.searchForm.value.area.id, this.searchForm.value.bloodGroup.id).subscribe((data) => {
        this.donarDetails=data;
        console.log(this.donarDetails);
        if(this.donarDetails.length!==0){
          this.noDonarDetails=true;
        }else 
          this.noDonarDetails=false;
    },
      error => {
        this.error = error.message;
        console.log(error);
      });
  }
}
