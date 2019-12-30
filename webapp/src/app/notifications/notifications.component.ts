import { Component, OnInit } from '@angular/core';
import { FaqsService } from '../faqs/faqs.service';
import { UserAuthService } from '../user-auth.service';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {
  status:boolean;
  constructor(private faqsService:FaqsService,private userAuthService:UserAuthService) { }

  ngOnInit() {
    this.faqsService.getAllAnsweredFaqsOfSingleUser(this.userAuthService.getUser()).subscribe(data=>{
      if(data.length!=0){
        this.status=true;
      }
    })
  }

}
