import { Component, OnInit } from '@angular/core';
import { UploadFilesService } from 'src/app/services/uploadService/upload-files.service';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css'],
})
export class FileUploadComponent implements OnInit {
  shortLink: string = '';
  loading: boolean = false; // Flag variable
  file: any = null; // Variable to store file

  constructor(private UploadFilesService: UploadFilesService) {}

  ngOnInit(): void {}

  onChange(event: any) {
    this.file = event.target.files[0];
  }

  // OnClick of button Upload
  onUpload() {
    this.loading = !this.loading;
    /* this.UploadFileService.upload(this.file).subscribe((event: any) => {
      if (typeof event === 'object') {
        // Short link via api response
        this.shortLink = event.link;

        this.loading = false; // Flag variable
      }
    }); */
  }
}
