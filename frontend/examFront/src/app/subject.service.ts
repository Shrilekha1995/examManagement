import { Injectable } from '@angular/core';
import{HttpClient,HttpClientModule,HttpHeaders } from '@angular/common/http';
import{Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubjectService {
public AddFlag: boolean = true;
  public displayFlag: boolean = true;
  constructor(private http: HttpClient) { }


getAllSubjects():Observable<any>{

  return this.http.get("http://localhost:8080/subject/all");
}

getAllTestbySId(sid: number):Observable<any>{

  return this.http.get(`http://localhost:8080/subject/${sid}`);
}


getAllQuestionByTId(tid: number):Observable<any>{
   return this.http.get(`http://localhost:8080/test/${tid}`);
}


}
