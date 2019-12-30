import { Injectable } from '@angular/core';
import { User } from './home/user.model';
import { RequestPostingDetails } from './request-posting/request-posting.model';

@Injectable({
    providedIn:'root'
})
export class UserAuthService{
    loggedIn: boolean;
    role: string;
    redirectUrl = '/';
    token: string;
    user: string;
    userDetails:User;
    requestDetails:RequestPostingDetails;
    constructor() { }
    public getToken() {
        return this.token;
    }
    public setToken(token: string) {
        this.token = token;
    }
    public getRole() {
        return this.role;
    }
    public setRole(role: string) {
        this.role = role;
    }
    public getUser() {
        return this.user;
    }
    public setUser(user: string) {
        this.user = user;
    }
    public getUserDetails(){
        return this.userDetails;
    }
    public setUserDetails(userDetails: User) {
        this.userDetails = userDetails;
    }
    public getRequestDetails(){
        return this.requestDetails;
    }
    public setRequestDetails(requestDetails:RequestPostingDetails){
        this.requestDetails=requestDetails;
    }
    logOut() {
        this.redirectUrl = '/';
        this.user = null;
        this.role = null;
        this.userDetails=null;
        this.loggedIn = false;
    }
}