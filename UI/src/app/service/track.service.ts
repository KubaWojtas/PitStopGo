import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Track} from "../track/model/track.model";

const baseUrl =  'http://localhost:8080/api/tracks';

@Injectable({
    providedIn: 'root'
})
export class TrackService {
    constructor(private http: HttpClient) {}

    getAll(): Observable<Track[]> {
        return this.http.get<Track[]>(baseUrl)
    }

    get(id: any): Observable<Track> {
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
