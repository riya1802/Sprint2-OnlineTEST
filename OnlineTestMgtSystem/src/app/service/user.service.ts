import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  addUser(user){
    return this.http.post("http://localhost:9090/user/addUser",user,{responseType:'text' as 'json'}); 
  }
  getAllUsers() {
    return this.http.get("http://localhost:9090/admin/viewAllUsers");
  }
  assignTest(userId,testId):Observable<any>{
    return this.http.post(`http://localhost:9090/admin/assignTest/${userId}/${testId}`,{responseType:'text' as 'json'});
  }
  deleteUser(userId){
    return this.http.delete("http://localhost:9090/admin/deleteUser/"+userId);
  }
}