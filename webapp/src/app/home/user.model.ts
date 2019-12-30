import { City } from '../search/city.model';
import { BloodGroup } from '../search/blood-group.model';
import { State } from '../search/state.model';
import { Area } from '../search/area.model';
export class User{
    id:number;
    username:string;
    password:string;
    firstName:string;
    lastName:string;
    weight:number;
    age:number;
    state:State;
    city:City;
    area:Area;
    gender:string;
    pincode:number;
    bloodGroup:BloodGroup;
    contactNumber:number;
    email:string;
}
