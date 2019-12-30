import { Injectable } from '@angular/core';
import { Feedback } from './feedback.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserAuthService } from '../user-auth.service';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn:'root'
})
export class FeedbackService{
    baseUrl=environment.baseUrl;
    constructor(private httpClient:HttpClient,private userAuthService:UserAuthService){}
    getAllFeedbacks():Observable<any>{
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.get<Feedback[]>(this.baseUrl+'/feedback',httpOptions)
    }
    addFeedback(feedback:Feedback):Observable<any>{
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.post(this.baseUrl+'/feedback',feedback,httpOptions)
    }
}