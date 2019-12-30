import { Injectable } from '@angular/core';
import { User } from './home/user.model';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn:'root'
})
export class UserService{
    baseUrl = environment.baseUrl;
    constructor(private httpClient:HttpClient){}
    addUser(user: User) {
        return this.httpClient.post(this.baseUrl + "/users", user);
    }
}