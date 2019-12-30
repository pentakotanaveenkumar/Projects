import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticateService } from '../authenticate.service';
import { User } from './user.model';
import { UserAuthService } from '../user-auth.service';

@Injectable({
    providedIn:'root'
})
export class AuthService{
    loggedIn = false;
    isAdmin = false;
    accessToken: string;
    redirectUrl = '/';
    userAuthenticated: User;
    error: string;
    inValidUser=false;
    constructor(private authenticateService: AuthenticateService, private userAuthService: UserAuthService, private router: Router) { }
    logIn(username: string, password: string) {
        this.authenticateService.authenticate(username, password).subscribe(data => {
            this.userAuthService.loggedIn = true;
            console.log(data.token);
            this.userAuthService.setToken(data.token);
            this.userAuthService.setRole(data.role);
            this.userAuthService.setUser(username);
            this.authenticateService.getUserDetails(username).subscribe(userDetails=>{
                this.userAuthService.setUserDetails(userDetails);
            })
            this.loggedIn = true;
            this.inValidUser=false;
            this.isAdmin = data.role === 'ADMIN';
            this.router.navigate(['/']);
        },
        (error) => {
                console.log(error.message);
                if (error.status === 401) {
                    this.error = "Invalid username/password";
                    this.inValidUser=true;
                }
            });

    }
    logOut() {
        this.redirectUrl = '/';
        this.loggedIn = false;
        this.isAdmin=false;
    }
    isAdminUser() {
        return this.isAdmin;
    }
}