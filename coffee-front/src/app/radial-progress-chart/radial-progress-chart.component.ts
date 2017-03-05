import { Component, AfterViewInit,Input } from '@angular/core';
import { UUID } from 'angular2-uuid';

declare var RadialProgressChart: any;

@Component({
	selector: 'radial-progress-chart',
	templateUrl: './radial-progress-chart.component.html',
	styleUrls: ['./radial-progress-chart.component.css']
})
export class RadialProgressChartComponent implements AfterViewInit {

	generatedId: string = 'radial-progress-chart' + UUID.UUID();

	@Input()
	config:RadialProgressChartConfig;

	ngAfterViewInit() {
		var chart = new RadialProgressChart('#' + this.generatedId, {
			diameter: 200,
			max: this.config.value * 1.33,
			round: true,
			series: [{
				labelStart: '\uF105',
				value: this.config.value,
				color: {
					linearGradient: {
						x1: '0%',
						y1: '100%',
						x2: '50%',
						y2: '0%',
						spreadMethod: 'pad'
					},
					stops: [{
						offset: '0%',
						'stop-color': '#fe08b5',
						'stop-opacity': 1
					}, {
						offset: '100%',
						'stop-color': '#ff1410',
						'stop-opacity': 1
					}]
				}
			}],
			center: {
				content: [function (value) {
					return value
				}, this.config.title],
				y: 25
			}
		});

		function getRandom(min, max) {
			return Math.random() * (max - min) + min;
		}

		//chart.update(Math.round(getRandom(100, 150)));
	}

}

export class RadialProgressChartConfig {

	constructor(public title: string, public value:number) {

	}

}