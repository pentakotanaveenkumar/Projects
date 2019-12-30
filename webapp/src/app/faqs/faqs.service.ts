import { Injectable } from "@angular/core";
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Faqs } from './faqs.model';
import { UserAuthService } from '../user-auth.service';

@Injectable({
    providedIn:'root'
})
export class FaqsService{
    baseUrl=environment.baseUrl;
    constructor(private httpClient:HttpClient,private userAuthService:UserAuthService){}
    getAllAnsweredQuestion():Observable<any>{
        return this.httpClient.get<Faqs[]>(this.baseUrl + "/faqs/answered")
    }
    getAllUnAnsweredQuestion():Observable<any>{
        /*const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };*/
        return this.httpClient.get<Faqs[]>(this.baseUrl + "/faqs/unanswered"/*,httpOptions*/)
    }
    addQuestioninFaq(faq:Faqs):Observable<any>{
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.post(this.baseUrl+'/faqs',faq,httpOptions)
    }
    addAnswerinFaq(answer:String,id:number):Observable<any>{
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.put(this.baseUrl+'/faqs/'+id,answer,httpOptions)
    }
    getAllAnsweredFaqsOfSingleUser(username:string):Observable<any>{
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.get<Faqs>(this.baseUrl+'/faqs/'+username,httpOptions)
    }
}