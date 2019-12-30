import { Component, OnInit } from '@angular/core';
import { FeedbackService } from './feedback.service';
import { Feedback } from './feedback.model';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  feedbackDetails:Feedback[];
  constructor(private feedbackService:FeedbackService) { }

  ngOnInit() {
    this.feedbackService.getAllFeedbacks().subscribe(data=>{
      this.feedbackDetails=data;
    })
  }

}
