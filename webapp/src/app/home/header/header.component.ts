import { Component, OnInit } from '@angular/core';
import { UserAuthService } from 'src/app/user-auth.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private userAuthSevice:UserAuthService,private authService:AuthService,private router:Router) { }

  ngOnInit() {
  }
  getUser(){
    return this.userAuthSevice.getUser();
  }
  isAuthenticated() {
    return this.authService.loggedIn;
  }
  isAdmin(){
    return this.authService.isAdmin;
  }
  getUserDetails(){
    return this.userAuthSevice.getUserDetails();
  }
  onSignOut() {
    this.authService.logOut();
    this.router.navigate([this.authService.redirectUrl]);
  }
}
