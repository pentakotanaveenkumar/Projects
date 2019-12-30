import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { Hospital } from './hospital.model';
import { SearchService } from '../search/search.service';
import { DonationDetailsService } from '../donation-details/donation-details.service';
import { RequestPostingDetails } from '../request-posting/request-posting.model';
import { UserAuthService } from '../user-auth.service';
import { FeedbackService } from '../feedback/feedback.service';
import { switchMap } from 'rxjs/operators';
import { RequestPostingService } from '../request-posting/request-posting.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-hospital-details',
  templateUrl: './hospital-details.component.html',
  styleUrls: ['./hospital-details.component.css']
})
export class HospitalDetailsComponent implements OnInit {
  hospitalForm: FormGroup;
  feedBackForm: FormGroup;
  hospitalsList: Hospital[];
  id: number;
  areaId: number;
  requestDetails: RequestPostingDetails;
  submitted = false;
  feedbackSubmit = false;
  requiredUnits: number;
  moreUnits = false;
  todayDate:string;
  endDate:string;
  data;
  constructor(private route: ActivatedRoute, private searchService: SearchService, private feedbackService: FeedbackService,private datePipe:DatePipe, private requestPostingService: RequestPostingService, private donationDetailsService: DonationDetailsService, private userAuthService: UserAuthService) {

  }

  ngOnInit() {
    this.todayDate=this.datePipe.transform(new Date(), 'yyyy-MM-dd');
    this.endDate=this.datePipe.transform(this.addDays(new Date(),7), 'yyyy-MM-dd');
    this.route.data.subscribe(data => {
      console.log(data);
      this.data = data;
      this.hospitalForm = new FormGroup({
        "requestPostingDetails": new FormControl(this.requestDetails),
        "hospital": new FormControl(null, Validators.required),
        "donationDate": new FormControl(null, Validators.required),
        "donationTime": new FormControl(null, Validators.required),
        "units": new FormControl(null, [Validators.required, Validators.max(2)]),
        "user": new FormControl(this.userAuthService.getUserDetails())
      })
      this.feedBackForm = new FormGroup({
        "feedback": new FormControl(null, Validators.required),
        "hospital": new FormControl(),
        "date": new FormControl(),
        "user": new FormControl(this.userAuthService.getUserDetails())
      })
    })
    this.searchService.getRequestPostingDetails(this.data.id).subscribe(data => {
      this.requestDetails = data;
      console.log(this.requestDetails);
      if (this.requestDetails) {
        this.hospitalForm.patchValue({
          requestPostingDetails: this.requestDetails
        })
      }
      this.searchService.getAllHospitalsByAreaId(this.data.area.id).subscribe(data => {
        this.hospitalsList = data;
        console.log(this.hospitalsList);
      })
    })

  }
  addDays(date: Date, days: number): Date {
    date.setDate(date.getDate() + days);
    return date;
}
  onSubmit() {
    console.log(this.hospitalForm.value);
    this.requiredUnits = this.data.units;
    console.log(this.requiredUnits);
    this.requiredUnits = this.data.units;
    if (this.data.units < this.hospitalForm.value.units) {
      this.moreUnits = true;
    } else {
      this.donationDetailsService.addSlotDetails(this.hospitalForm.value).pipe(switchMap(() => this.requestPostingService.putPostingDetails(this.data, this.hospitalForm.value.units))).subscribe(data => {
        this.submitted = true;
      })
    }
  }
  onSubmitFeedback() {
    this.feedBackForm.value.date = this.hospitalForm.value.donationDate;
    this.feedBackForm.value.hospital = this.hospitalForm.value.hospital.name;
    this.feedbackService.addFeedback(this.feedBackForm.value).subscribe(data => {
      this.feedbackSubmit = true;
    })
  }
}
