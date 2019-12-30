import { UserAuthService } from '../user-auth.service';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { State } from './state.model';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { BloodGroup } from './blood-group.model';
import { City } from './city.model';
import { Area } from './area.model';
import { DonationDetails } from './donation-details.model';
import { Hospital } from '../hospital-details/hospital.model';
import { RequestPostingDetails } from '../request-posting/request-posting.model';

@Injectable({
    providedIn:'root'
})
export class SearchService{
    baseUrl=environment.baseUrl;
    constructor(private httpClient:HttpClient,private userAuthService:UserAuthService){

    }
    getAllStates(): Observable<any> {
        /*const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };*/
        return this.httpClient.get<State[]>(this.baseUrl + "/states"/*, httpOptions*/);
    }
    getAllBloodGroups():Observable<any>{
        /*const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };*/
        return this.httpClient.get<BloodGroup[]>(this.baseUrl + "/bloodGroups"/*, httpOptions*/);
    }
    getAllCitiesByStateId(stateId:number):Observable<any>{
         /*const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };*/
        return this.httpClient.get<City[]>(`${this.baseUrl+"/cities"}/${stateId}`/*,httpOptions*/)
    }
    getAllAreasByCityId(cityId:number):Observable<any>{
         /*const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };*/
        return this.httpClient.get<Area[]>(`${this.baseUrl+"/areas"}/${cityId}`/*,httpOptions*/)
    }
    getAllHospitalsByAreaId(areaId:number):Observable<any>{
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.get<Hospital[]>(`${this.baseUrl+"/hospitals"}/${areaId}`,httpOptions)
    }
    getAllDonationDetails(stateId,cityId,areaId,bloodGroupId):Observable<any>{
         const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.userAuthService.getToken()
            })
        };
        return this.httpClient.get<DonationDetails[]>(`${this.baseUrl+"/donationDetails"}/${stateId}/${cityId}/${areaId}/${bloodGroupId}`,httpOptions)
    }
    getRequestPostingDetails(id:number):Observable<any>{
        const httpOptions = {
           headers: new HttpHeaders({
               'Content-Type': 'application/json',
               'Authorization': 'Bearer ' + this.userAuthService.getToken()
           })
       };
       return this.httpClient.get<RequestPostingDetails>(`${this.baseUrl+"/requestPostingDetails"}/${id}`,httpOptions)
   }
    getAllRequestPostingDetails():Observable<any>{
       return this.httpClient.get<RequestPostingDetails[]>(`${this.baseUrl+"/requestPostingDetails"}`)
   }
}