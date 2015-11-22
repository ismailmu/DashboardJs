Ext.define('DashboardJs.store.helpdesk.Helpdesk', {
    extend: 'Ext.data.Store',
    model: 'DashboardJs.model.helpdesk.Helpdesk',
    autoLoad: false,
    pageSize: DashboardJs.Global.pageSize,
    remoteSort: true,
    remoteFilter:true,
    proxy:{
        type: 'ajax',
        url : 'HelpdeskServlet?type=list',
        reader: {
            root: 'helpdesks',
            totalProperty: 'totalCount'
        }
    },
    // sends single sort as multi parameter
    simpleSortMode: true,
    sorters: [{
        property: 'wisma',
        direction: 'ASC'
    }]
});