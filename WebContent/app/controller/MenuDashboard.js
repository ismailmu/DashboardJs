var global_menu="";
Ext.define('DashboardJs.controller.MenuDashboard', {
	extend: 'Ext.app.Controller',
	requires:['Ext.window.MessageBox','DashboardJs.view.wisma.List','DashboardJs.view.helpdesk.List'],
	
	views: ['core.MenuDashboard'],
	
//	stores: ['menu.MenuStore'],
	
	refs:[{
		ref:'wismaList',
		selector:'wismaList',
		autoCreate: true,
		xtype: 'wismaList'
	},{
		ref:'searchDate',
		selector: 'searchDate'
	}
//	,{
//		ref:'menuStore',
//		selector: 'menuStore'
//	}
	,{
		ref:'menuDashboard',
		autoCreate: true,
		xtype: 'menuDashboard',
		selector: 'menuDashboard'
	},{
		ref:'mainContent',
		selector: '#mainContent'
	},{
		ref:'helpdeskDailyList',
		selector:'helpdeskDailyList',
		autoCreate: true,
		xtype: 'helpdeskDailyList'
		 
	}],
	onLaunch: function() {
//		var taskbutton = Ext.create('Ext.button.Button', {
//             text: 'Show xx Window',
//             handler: function() {
//                 win.show();
//             }
//         });
//		this.getMenuDashboard().add(taskbutton);
//		console.log(this.getMenuDashboard());
	},
	
	init: function() {
		this.control({
			//'menuDashboard menuitem[action=etlLogClick]': {
			'menuDashboard menuitem': {
                click: this.clickMenu
            },
            'menuDashboard button[action=homeClick]': {
                click: this.clickMenu
            },
            'searchDate': {
            	change: this.changeDateFilter
            }
		});
		
		this.callParent(arguments);
	},
	changeDateFilter: function(cmp) {
		//console.log(cmp);
		this.showPanelMenu(cmp.getValue());
	},
	showPanelMenu: function(value) {
    	if (global_menu == 'helpdeskDailyClick') {
			var storeHelpdeskDaily = this.getHelpdeskDailyList().getStore();
			storeHelpdeskDaily.getProxy().setExtraParam("dateFilter", value);
			storeHelpdeskDaily.load();
			this.getMainContent().add(this.getHelpdeskDailyList());
			this.getSearchDate().show();
		}
    },
	clickMenu: function(btn) {
		//console.log(btn.action);
		var main=this.getMainContent();
		main.removeAll();
		if (btn.action == 'wismaListClick') {
			this.getWismaList().getStore().load();
			main.add(this.getWismaList());
			this.getSearchDate().hide();
		}else { //selain wisma
			global_menu=btn.action;
			this.getSearchDate().setValue(new Date());
			//lebih enak pake function daripada call event(fireEvent)
			//this.fireEvent('changeDateFilter',this.getSearchDate());
			this.showPanelMenu(this.getSearchDate().getValue());
		}
    }
});