import {Observable} from "rxjs";
import {Driver} from "../driver/model/driver.model";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

const baseUrl =  'http://localhost:8080/api/drivers';

@Injectable({
    providedIn: 'root'
})
export class DriverService {
    constructor(private http: HttpClient) {}

    getAll(): Observable<Driver[]> {
        return this.http.get<Driver[]>(baseUrl)
    }

    get(id: any): Observable<Driver> {
        return this.http.get(`${baseUrl}/${id}`);
    }

    create(data: any): Observable<any> {
        return this.http.post(baseUrl, data);
    }

    update(id: any, data: any): Observable<any> {
        return this.http.put(`${baseUrl}/${id}`, data);
    }

    delete(id: any): Observable<any> {
        return this.http.delete(`${baseUrl}/${id}`);
    }
}