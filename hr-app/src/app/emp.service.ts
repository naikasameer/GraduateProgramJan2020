import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from './employee';
import { Observable } from 'rxjs';
import { Project } from './project';

// this service will be available for required components
// declare the service in the components to mark if they want to use this service 
@Injectable({
  providedIn: 'root'
})
export class EmpService {
  serviceURL:string

  // declare the client object in constructor to use in this service
  constructor(private httpSvc:HttpClient) { 
    this.serviceURL="http://localhost:7777/hrapp/employees"
  }

  findEmpByEmpno(empno:number):Observable<Employee>{
    return this.httpSvc.get<Employee>(this.serviceURL+"/find/"+empno)
  }

  findProjectsByEmpno(empno:number):Observable<Project[]>{
    return this.httpSvc.get<Project[]>(this.serviceURL+"/projects/"+empno)
  }

  registerProjectForEmployee(empno:number,newProject:Project):Observable<Project>{
      var contentData = "empno="+empno
                         +"&name="+newProject.name
                         +"&location="+newProject.location

      const httpOptions= {
        headers: new HttpHeaders(
              {"Content-Type":"application/x-www-form-urlencoded"})
      }
                    
      return this.httpSvc.post<Project>(
        this.serviceURL+"/projects/register",  // URL
        contentData,    // data for the server
        httpOptions)    // header options
  }





}




