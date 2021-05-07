import { Component, OnInit } from '@angular/core';
import { IPet } from './IPet';

@Component({
  selector: 'app-angular-show-pet-info',
  templateUrl: './angular-show-pet-info.component.html',
  styleUrls: ['./angular-show-pet-info.component.scss']
})
export class AngularShowPetInfoComponent implements OnInit {
  pet: IPet = {
    name: 'puppie',
    image: 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg'
  };

  constructor() { }

  ngOnInit(): void {
  }

}
