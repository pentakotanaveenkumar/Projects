import { Component, OnInit } from '@angular/core';
import { AuthService } from '../home/auth.service';
import { FaqsService } from './faqs.service';
import { Faqs } from './faqs.model';
import { FormGroup, FormControl, RequiredValidator, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from '../user-auth.service';

@Component({
  selector: 'app-faqs',
  templateUrl: './faqs.component.html',
  styleUrls: ['./faqs.component.css']
})
export class FaqsComponent implements OnInit {
  unAnsweredFaqs: Faqs;
  answeredFaqs: Faqs;
  isAdmin: boolean;
  faqsForm: FormGroup;
  faqsQuestionForm: FormGroup;
  success=false;
  posted=false;
  nodata=false;
  faq:Faqs;
  constructor(private authService: AuthService, private faqsService: FaqsService, private router: Router,private userAuthService:UserAuthService) { }

  ngOnInit() {
    this.isAdmin = this.authService.isAdmin;
    this.faqsService.getAllUnAnsweredQuestion().subscribe(data => {
      this.unAnsweredFaqs = data;
      if(data.length==0){
        this.nodata=true;
      }else
        this.nodata=false;
    })
    this.faqsService.getAllAnsweredQuestion().subscribe(data => {
      this.answeredFaqs = data;
    })
    this.faqsForm = new FormGroup({
      "answer": new FormControl(null, Validators.required),
    })
    this.faqsQuestionForm = new FormGroup({
      "question": new FormControl(null, Validators.required),
      "user":new FormControl(this.userAuthService.getUserDetails())
    })
  }
  onPost() {
    if (!this.authService.loggedIn) {
      this.router.navigate(['/login']);
    } else {
      this.faqsService.addQuestioninFaq(this.faqsQuestionForm.value).subscribe(data => {
        this.success=true
      })
    }
  }
  onSubmit(id:number) {
    this.faqsService.addAnswerinFaq(this.faqsForm.value.answer,id).subscribe(data => {
      this.posted=true;
    })
  }
}
