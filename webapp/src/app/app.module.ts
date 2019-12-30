import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from "@angular/forms"

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './home/signup/signup.component';
import { HeaderComponent } from './home/header/header.component';
import { LoginComponent } from './home/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { SearchComponent } from './search/search.component';
import { DonationDetailsComponent } from './donation-details/donation-details.component';
import { RequestPostingComponent } from './request-posting/request-posting.component';
import { HospitalDetailsComponent } from './hospital-details/hospital-details.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FaqsComponent } from './faqs/faqs.component';
import { DonorSlotDetailsComponent } from './donation-details/donor-slot-details/donor-slot-details.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignupComponent,
    HeaderComponent,
    LoginComponent,
    SearchComponent,
    DonationDetailsComponent,
    RequestPostingComponent,
    HospitalDetailsComponent,
    FeedbackComponent,
    FaqsComponent,
    DonorSlotDetailsComponent,
    NotificationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
