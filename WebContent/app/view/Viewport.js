Ext.define('DashboardJs.view.Viewport', {
	extend : 'Ext.container.Viewport',

	layout : 'border',
	items : [{
		region : 'north',
		border : false,
		dockedItems: [{
	        items: [{
	        	border: false,
	        	html:'<div id="demo-theme"></div><div id=demo-title>IT INTERNAL DASHBOARD</div>'
	        }, {
				xtype: 'menuDashboard'
	        }]
	   }]
	}, {
		region : 'center',
		layout: 'card',
		id: 'mainContent',
		border: false
	}]
});