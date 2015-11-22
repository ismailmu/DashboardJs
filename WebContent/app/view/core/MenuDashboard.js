Ext.define('DashboardJs.view.core.MenuDashboard', {
	extend : 'Ext.toolbar.Toolbar',

	alias : 'widget.menuDashboard',

	requires : [ 'DashboardJs.view.core.SearchDate' ],

	padding : 5,
	border : false
	// ,store: 'menu.MenuStore'
	,
	items : [ {
		xtype : 'button',
		text : 'Home',
		iconCls : 'home16'
	}, {
		xtype : 'tbseparator'
	}, {
		text : 'EOD',
		iconCls : 'eod16',
		menu : [ {
			text : 'EOD Duration',
			iconCls : 'table16'
		}, {
			text : 'EOD Daily',
			iconCls : 'table16'
		} ]
	}, {
		xtype : 'tbseparator'
	}, {
		text : 'FTP',
		iconCls : 'ftp16',
		menu : [ {
			text : 'Detail Trx Processed',
			iconCls : 'chart16'
		}, {
			text : 'Daily Synchronization Log',
			iconCls : 'table16'
		} ]
	}, {
		xtype : 'tbseparator'
	}, {
		xtype : 'button',
		text : 'Helpdesk',
		iconCls : 'helpdesk16',
		menu : [ {
			text : 'Helpdesk Daily',
			iconCls : 'table16',
			action : 'helpdeskDailyClick'
		} ]
	}, {
		xtype : 'tbseparator'
	}, {
		text : 'Snapshot',
		iconCls : 'snapshot16',
		menu : [ {
			text : 'Portfolio Snapshot Accumulation',
			iconCls : 'table16'
		}, {
			text : 'Portfolio Snapshot Daily',
			iconCls : 'table16'
		} ]
	}, {
		xtype : 'tbseparator'
	}, {
		text : 'Wisma',
		iconCls : 'wisma16',
		menu : [ {
			text : 'Wisma List',
			iconCls : 'table16',
			action : 'wismaListClick'
		} ]
	}, {
		xtype : 'tbseparator'
	}, {
		text : 'DTUR',
		iconCls : 'dtur16',
		menu : [ {
			text : 'ETL Log',
			iconCls : 'table16',
			action : 'etlLogClick'
		} ]
	}, {
		xtype : 'tbseparator'
	}, {
		xtype : 'tbfill'
	}, {
		xtype : 'searchDate'
	}, {
		xtype : 'tbseparator'
	} ]

});
/*
 * items: [{ xtype:'button', text: 'Home', iconCls: 'home16' },{
 * xtype:'tbseparator' },{ text: 'EOD', iconCls: 'eod16', menu: [{text: 'EOD
 * Duration',iconCls: 'table16'},{text: 'EOD Daily',iconCls: 'table16'}] },{
 * xtype:'tbseparator' },{ text: 'FTP', iconCls: 'ftp16', menu: [{text: 'Detail
 * Trx Processed',iconCls: 'chart16'},{text: 'Daily Synchronization
 * Log',iconCls: 'table16'}] },{ xtype:'tbseparator' },{ xtype: 'button', text:
 * 'Helpdesk', iconCls: 'helpdesk16', menu: [{text: 'Helpdesk Daily',iconCls:
 * 'table16',action:'helpdeskDailyClick'}] } ,{ xtype:'tbseparator' },{ text:
 * 'Snapshot', iconCls: 'snapshot16', menu: [{text: 'Portfolio Snapshot
 * Accumulation',iconCls: 'table16'} ,{text: 'Portfolio Snapshot Daily',iconCls:
 * 'table16'}] },{ xtype:'tbseparator' },{ text: 'Wisma', iconCls: 'wisma16',
 * menu: [{text: 'Wisma List',iconCls: 'table16',action:'wismaListClick'}] },{
 * xtype:'tbseparator' },{ text: 'DTUR', iconCls: 'dtur16', menu: [{text: 'ETL
 * Log',iconCls: 'table16',action:'etlLogClick'}] },{ xtype:'tbseparator' },{
 * xtype:'tbfill' },{ xtype: 'searchDate' },{ xtype:'tbseparator' }]
 */