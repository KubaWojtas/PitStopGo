import {Observable} from "rxjs";
import {Driver} from "../driver/model/driver.model";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Track} from "../team/model/team.model";
import {Team} from "../track/model/track.model";

const baseUrl =  'http://localhost:8080/api/teams';

@Injectable({
    providedIn: 'root'
})
export class TeamService {
    constructor(private http: HttpClient) {}

    getAll(): Observable<Team[]> {
        return this.http.get<Team[]>(baseUrl)
    }

    get(id: any): Observable<Team> {
        return this.http.get(`${baseUrl}/${id}`);
    }

    create(data: any): Observable<any> {
        return this.http.post(`${baseUrl}/add`, data);
    }

    update(id: any, data: any): Observable<any> {
        return this.http.put(`${baseUrl}/${id}`, data);
    }

    delete(id: any): Observable<any> {
        return this.http.delete(`${baseUrl}/${id}/delete`);
    }
}