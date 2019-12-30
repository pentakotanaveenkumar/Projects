import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './home/signup/signup.component';
import { LoginComponent } from './home/login/login.component';
import { SearchComponent } from './search/search.component';
import { DonationDetailsComponent } from './donation-details/donation-details.component';
import { AuthGaurdService } from './auth-guard.service';
import { RequestPostingComponent } from './request-posting/request-posting.component';
import { HospitalDetailsComponent } from './hospital-details/hospital-details.component';
import { DonorSlotDetailsComponent } from './donation-details/donor-slot-details/donor-slot-details.component';
import { FaqsComponent } from './faqs/faqs.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { FeedbackComponent } from './feedback/feedback.component';


const routes: Routes = [
    { path:"", component:HomeComponent},
    { path:"signUp", component:SignupComponent},
    { path:"login", component:LoginComponent},
    { path:"faqs", component:FaqsComponent},
    { path:"feedback", component:FeedbackComponent},
    { path:"search", component:SearchComponent, canActivate: [AuthGaurdService]},
    { path:"donationDetails",component:DonationDetailsComponent, canActivate: [AuthGaurdService]},
    { path:"requestPosting",component:RequestPostingComponent, canActivate: [AuthGaurdService]},
    { path:"hospitalDetails",component:HospitalDetailsComponent, canActivate: [AuthGaurdService]},
    { path:"donorSlotDetails/:id",component:DonorSlotDetailsComponent, canActivate: [AuthGaurdService]},
    { path:"notifications",component:NotificationsComponent, canActivate: [AuthGaurdService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  
 }
