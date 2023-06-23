import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UploadFilesService {
  private baseUrl = 'http://localhost:8080';

  constructor(private HttpClient: HttpClient) {}

 // Returns an observable
 upload(file:any):Observable<any> {
  
  // Create form data
  const formData = new FormData(); 
    
  // Store form name as "file" with file data
  formData.append("file", file, file.name);
    
  // Make http post request over api
  // with formData as req
  return this.HttpClient.post(this.baseUrl, formData)
}
}
