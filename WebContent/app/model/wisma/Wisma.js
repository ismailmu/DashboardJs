Ext.define('DashboardJs.model.wisma.Wisma', {
    extend: 'Ext.data.Model',
    
    fields: [
         {name: 'id',  type: 'int'},
	     {name: 'kcs', type: 'string'},
	     {name: 'kcsName', type: 'string'},
	     {name: 'wisma', type: 'string'},
	     {name: 'wismaName', type: 'string'},
	     {name: 'address', type: 'string'},
	     {name: 'rtrw', type: 'string'},
	     {name: 'kelurahan', type: 'string'},
	     {name: 'kecamatan', type: 'string'},
	     {name: 'kabupaten', type: 'string'},
	     {name: 'propinsi', type: 'string'},
	     {name: 'zipcode', type: 'string'},
	     {name: 'telephone', type: 'string'}
    ],
    idProperty: 'id'
});