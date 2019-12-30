import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SearchService } from 'src/app/search/search.service';
import { Hospital } from 'src/app/hospital-details/hospital.model';
import { DonationDetailsService } from '../donation-details.service';
import { UserAuthService } from 'src/app/user-auth.service';
import { FeedbackService } from 'src/app/feedback/feedback.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-donor-slot-details',
  templateUrl: './donor-slot-details.component.html',
  styleUrls: ['./donor-slot-details.component.css']
})
export class DonorSlotDetailsComponent implements OnInit {
  donorHospitalForm:FormGroup;
  feedBackForm:FormGroup;
  id:number;
  hospitalsList:Hospital[];
  submitted=false;
  feedbackSubmit=false;
  todayDate:string;
  endDate:string;
  constructor(private route:ActivatedRoute,private datePipe: DatePipe,private searchService:SearchService,private donationDetailsService:DonationDetailsService,private feedbackService:FeedbackService,private userAuthService:UserAuthService,private router:Router) { 
    
  }

  ngOnInit() {
    this.todayDate=this.datePipe.transform(new Date(), 'yyyy-MM-dd');
    this.endDate=this.datePipe.transform(this.addDays(new Date(),7), 'yyyy-MM-dd');
    this.donorHospitalForm=new FormGroup({
      "donationDetails":new FormControl(this.donationDetailsService.donationDetails),
      "hospital":new FormControl(null,Validators.required),
      "donationDate":new FormControl(null,Validators.required),
      "donationTime":new FormControl(null,Validators.required)
    })
    this.feedBackForm=new FormGroup({
      "feedback":new FormControl(null,Validators.required),
      "hospital":new FormControl(),
      "date":new FormControl(),
      "user":new FormControl(this.userAuthService.getUserDetails())
    })
    this.route.params.subscribe((params:Params)=>{
      this.id=params['id'];
    })
    this.searchService.getAllHospitalsByAreaId(this.id).subscribe(data=>{
      this.hospitalsList=data;
      console.log(this.hospitalsList);
    })
  }
  addDays(date: Date, days: number): Date {
    date.setDate(date.getDate() + days);
    return date;
}
  onSubmit(){
    console.log(this.donorHospitalForm.value); 
    this.donationDetailsService.addDonorSlotDetails(this.donorHospitalForm.value).subscribe(data=>{
      this.submitted=true;
    })
  }
  onSubmitFeedback(){
    this.feedBackForm.value.date=this.donorHospitalForm.value.donationDate;
    this.feedBackForm.value.hospital=this.donorHospitalForm.value.hospital.name;
    this.feedbackService.addFeedback(this.feedBackForm.value).subscribe(data=>{
      this.feedbackSubmit=true;
    })
  }

}
