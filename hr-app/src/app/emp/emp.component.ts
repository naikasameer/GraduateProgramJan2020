import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { Project } from '../project';
import { EmpService } from '../emp.service';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.css']
})
export class EmpComponent implements OnInit {

  currentEmployee: Employee
  employeeProjects: Project[]
  isEmpEditing:boolean
  isProjectFormVisible:boolean

  constructor(private empService:EmpService) { 
      //initialize the data variables in constructor
      this.isEmpEditing=false
      this.isProjectFormVisible=false

      this.currentEmployee=
        {
          empno:1,
          name:"UNKNOWN",
          designation:"UNKNOWN",
          salary:-1
        }
      this.employeeProjects=
        [
          {projectId:101,name:"Admin",location:"UK"},
          {projectId:3434,name:"App",location:"US"}
        ]
  }
  // connect to the service once the component is loaded using ngOnInit()
  ngOnInit(): void {
    this.fetchEmployeeFromServer()      
  }

  fetchEmployeeProjectsFromServer(){
      this.empService.findProjectsByEmpno(this.currentEmployee.empno).subscribe(
        response =>{
            this.employeeProjects = response
        }
      )
  }

  fetchEmployeeFromServer(){
    this.empService.findEmpByEmpno(this.currentEmployee.empno).subscribe(
      // use the response to initialize the component properties
    response => {  
          console.log("Response received")
          this.currentEmployee = response
          this.fetchEmployeeProjectsFromServer()
    })
  }

  showProjectForm(){
    this.isProjectFormVisible=true
  }

  addNewProject(newProject:Project){
    // push/add the form data in the employeeProjects array
    //this.employeeProjects.push(newProject)

    this.empService.registerProjectForEmployee(
        this.currentEmployee.empno,newProject).subscribe(
          response =>{
            this.fetchEmployeeProjectsFromServer()
          }
        )

    this.isProjectFormVisible=false
  }
  
  toggleEmpEditForm(){
    this.isEmpEditing=!this.isEmpEditing
    this.fetchEmployeeFromServer()
  }

}
