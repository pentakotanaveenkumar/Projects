import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserAuthService } from '../user-auth.service';
import { RequestPostingDetails } from './request-posting.model';

@Injectable({
    providedIn:'root'
})
export class RequestPostingService{
    baseUrl=environment.baseUrl;
    constructor(private httpClient:HttpClient,private userAuthService:UserAuthService){
        
    }
    addRequestPostingDetails(requestPostingDetails:RequestPostingDetails):Observable<any>{
        const httpOptions = {
           headers: new HttpHeaders({
               'Content-Type': 'application/json',
               'Authorization': 'Bearer ' + this.userAuthService.getToken()
           })
       };
       return this.httpClient.post(`${this.baseUrl+"/requestPostingDetails"}`,requestPostingDetails,httpOptions)
   }
   putPostingDetails(requestPostingDetails:RequestPostingDetails,units:number):Observable<any>{
    const httpOptions = {
       headers: new HttpHeaders({
           'Content-Type': 'application/json',
           'Authorization': 'Bearer ' + this.userAuthService.getToken()
       })
   };
   return this.httpClient.put(`${this.baseUrl+"/requestPostingDetails/"+units}`,requestPostingDetails,httpOptions)
}
}