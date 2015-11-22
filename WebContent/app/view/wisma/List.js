function customRenderWisma(value, metaData, record, rowIndex) {
	var id = Ext.id();
	Ext.defer(function() {
		Ext.create('Ext.button.Button', {
			renderTo : id,
			text : value,
			action:'show',
			iconCls : 'view16'
//			,handler : function() {
//				var view = Ext.widget('employeelist',{title:'Detail Employee Wisma ' + value});
//		 		view.show();
//			}
		});
	}, 50);
	return Ext.String.format('<div id="{0}"></div>', id);
};
// function intWinCreate(){
// Ext.create('Ext.window.Window', {
// id:'edit_segtype_win',
// title:'msg',
// layout: 'fit',
// modal:true,
// width: 400,
// height: 300,
// constrain:true
// }).show();
// };

Ext.define('DashboardJs.view.wisma.List', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.wismaList',

	// entah kenapa ada error aneh bin ajaib di function getpoint dibrowser
	// tapi anehnya masih bisa jalan
	// ditambahkan Ext.util.Point, error tidak lagi muncul
	requires : [ 'Ext.ux.grid.FiltersFeature', 'Ext.util.Point' ],
	title : 'Wisma List',
	iconCls : 'table16',
	loadMask : true,
	forceFit: true,
	initComponent : function() {
		this.store = 'wisma.Wisma',
		this.columns = [
			Ext.create('Ext.grid.RowNumberer',{resizable: true,width:30}), {
				header : 'KCS',
				dataIndex : 'kcs',
				//flex: 1,
				width: 30,
				sortable : true
			}, {
				header : 'Wisma',
				dataIndex : 'wisma',
				//flex: 1,
				width: 60,
				sortable : true,
				renderer : customRenderWisma
			}, {
				header : 'Wisma Name',
				dataIndex : 'wismaName',
				//flex: 1,
				sortable : true
			}, {
				header : 'Address',
				dataIndex : 'address',
				//flex: 1,
				width:200,
				sortable : true
			}, {
				header : 'RT/RW',
				dataIndex : 'rtrw',
				//flex: 1,
				sortable : true
			}, {
				header : 'Kelurahan',
				dataIndex : 'kelurahan',
				//flex: 1,
				sortable : true
			}, {
				header : 'Kecamatan',
				dataIndex : 'kecamatan',
				//flex: 1,
				sortable : true
			}, {
				header : 'Kabupaten',
				dataIndex : 'kabupaten',
				//flex: 1,
				sortable : true
			}, {
				header : 'Provinsi',
				dataIndex : 'provinsi',
				//flex: 1,
				sortable : true
			}, {
				header : 'Zip Code',
				dataIndex : 'zip',
				//flex: 1,
				sortable : true
			}, {
				header : 'Telephone',
				dataIndex : 'telphone',
				//flex: 1,
				sortable : true
			} ],
		this.dockedItems = [ {
			xtype : 'pagingtoolbar',
			store : 'wisma.Wisma', // same store GridPanel is using
			dock : 'bottom',
			displayInfo : true
		} ], 
		this.features = {
			ftype : 'filters',
			encode : true, // json encode the filter query
			local : false,
			filters : [ {
				type : 'string',
				dataIndex : 'kcs'
			} ]
		};

		this.callParent(arguments);
	}
});