import { Component, OnInit } from '@angular/core';

declare var RadialProgressChart:any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'app works!';

  ngOnInit(){
    var calories = new RadialProgressChart('.calories', {
			diameter : 200,
			max : 300,
			round : true,
			series : [ {
				labelStart : '\uF105',
				value : 500,
				color : {
					linearGradient : {
						x1 : '0%',
						y1 : '100%',
						x2 : '50%',
						y2 : '0%',
						spreadMethod : 'pad'
					},
					stops : [ {
						offset : '0%',
						'stop-color' : '#fe08b5',
						'stop-opacity' : 1
					}, {
						offset : '100%',
						'stop-color' : '#ff1410',
						'stop-opacity' : 1
					} ]
				}
			} ],
			center : {
				content : [ function(value) {
					return value
				}, 'Notifications' ],
				y : 25
			}
		});

    var gpa = new RadialProgressChart('.gpa', {
			diameter : 200,
			max : 300,
			round : true,
			series : [ {
				labelStart : '\uF105',
				value : 100,
				color : [ 'red', '#7CFC00' ]
			} ],
			center : function(d) {
				return d + ' Cups'
			}
		});

		function getRandom(min, max) {
			return Math.random() * (max - min) + min;
		}

		calories.update(Math.round(getRandom(130, 150)));
		gpa.update(getRandom(200, 300));

  } 
  
}