import { Component } from '@angular/core';

@Component({
  selector: 'app-image-slider',
  templateUrl: './image-slider.component.html',
  styleUrls: ['./image-slider.component.css']
})
export class ImageSliderComponent {
  title= 'image-slider';

  imageSize: any = {
    width: 400, height: 400, space: 4
  }

  imageObject: Array<object> = [
    {
      image: 'assets/images/1.jpg',
      thumbImage: 'assets/images/0.jpg',
      alt: 'img',
      //title: 'Image 1'
    }, {
      image: 'assets/images/1.jpg',
      thumbImage: 'assets/images/1.jpg',
      alt: 'img',
      //title: 'Image 1'
    }, {
      image: 'assets/images/2.jpg',
      thumbImage: 'assets/images/2.jpg',
      alt: 'img',
      //title: 'Image 1'
    }, {
      image: 'assets/images/3.jpg',
      thumbImage: 'assets/images/3.jpg',
      alt: 'img',
      //title: 'Image 1'
    }, {
      image: 'assets/images/4.jpg',
      thumbImage: 'assets/images/4.jpg',
      alt: 'img',
      //title: 'Image 1'
    }, {
      image: 'assets/images/5.jpg',
      thumbImage: 'assets/images/5.jpg',
      alt: 'img',
      //title: 'Image 1'
    }
];
}
