import { Injectable } from '@angular/core';
import { HttpClient,HttpErrorResponse } from '@angular/common/http'
import { throwError, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

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
  assignTest(userId,testId){
    return this.http.post("http://localhost:9090/admin/assignTest/"+userId+"/"+testId,{responseType:'text' as 'json'})
    .pipe(catchError(this.errorHandler))
  }
  deleteUser(userId){
    return this.http.delete("http://localhost:9090/admin/deleteUser/"+userId,{responseType: 'text' as 'json'});
  }
  updateUser(userId,user){
    return this.http.put("http://localhost:9090/user/updateUser/"+userId,user)
  }
  errorHandler(error: HttpErrorResponse) {
    return throwError(error)
  }
}
