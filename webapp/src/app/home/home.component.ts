import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { RequestPostingDetails } from '../request-posting/request-posting.model';
import { SearchService } from '../search/search.service';
import { UserAuthService } from '../user-auth.service';
import { DonationDetailsService } from '../donation-details/donation-details.service';
import { User } from './user.model';
import { AuthenticateService } from '../authenticate.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  requestDetails: RequestPostingDetails[];
  noRequestDetails: boolean;
  bloodGroupNotMatched: boolean;
  clicked: boolean;
  isActive: boolean;
  isUserActive: boolean;
  loggedIn: boolean;
  activeUser: boolean;
  email;
  user: User;
  constructor(private router: Router,private authenticateService: AuthenticateService, private authService: AuthService, private donationDetailsService: DonationDetailsService, private searchService: SearchService, private userAuthService: UserAuthService) { }

  ngOnInit() {
    this.searchService.getAllRequestPostingDetails().subscribe(data => {
      this.requestDetails = data;
      if (this.requestDetails.length !== 0)
        this.noRequestDetails = true
      else
        this.noRequestDetails = false
    })
    this.clicked = false;
    if (this.authService.loggedIn) {
     this.userAuthService.getUserDetails();
     this.authenticateService.getUserDetails(this.userAuthService.getUser()).subscribe(data=>{
       this.email=data.email
     })
      this.donationDetailsService.isActiveDonor(this.userAuthService.getUser()).subscribe(data => {
        console.log(data)
        this.donationDetailsService.isHeActiveDonor(this.userAuthService.getUser()).subscribe(active => {
          if (data & active) {
            this.activeUser = true;
          } else
            this.activeUser = false;
        })
      })
    }
  }
  goToRegistration(): any {
    if (!this.authService.loggedIn) {
      this.router.navigate(['/login'], { queryParams: { notLogged: true } });
    } else {
      this.donationDetailsService.isActiveDonor(this.userAuthService.getUser()).subscribe(data => {
        console.log(data)
        this.isActive = !data;
        this.donationDetailsService.isHeActiveDonor(this.userAuthService.getUser()).subscribe(active => {
          this.isUserActive = !active;
          if (data && active) {
            this.router.navigate(['/donationDetails']);
          }
        })
      })
    }
  }
  onSubmit(requestDetail: RequestPostingDetails) {
    this.clicked = true;
    if (!this.userAuthService.loggedIn) {
      this.router.navigate(['/login']);
    }
    else {
      console.log(requestDetail.bloodGroup.name === this.userAuthService.getUserDetails().bloodGroup.name);
      if (!(requestDetail.bloodGroup.name === this.userAuthService.getUserDetails().bloodGroup.name)) {
        this.bloodGroupNotMatched = true;
      } else {
        this.bloodGroupNotMatched = false;
        this.donationDetailsService.isActiveDonor(this.userAuthService.getUser()).subscribe(data => {
          console.log(data)
          this.isActive = !data;
          this.donationDetailsService.isHeActiveDonor(this.userAuthService.getUser()).subscribe(active => {
            this.isUserActive = !active;
            if (data && active) {
              let route = this.router.config.find(r => r.path === 'hospitalDetails');
              route.data = requestDetail;
              this.router.navigateByUrl("/hospitalDetails");
            }
          })
        })
      }
    }
  }
}

