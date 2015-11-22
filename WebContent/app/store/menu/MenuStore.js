Ext.define('DashboardJs.store.menu.MenuStore', {
    extend: 'Ext.data.Store',
    model: 'DashboardJs.model.menu.MenuModel',
    autoLoad: true,
    //id: 'menuStore',
    proxy:{
        type: 'ajax',
        url: 'MenuServlet',
        reader: 'json'
    }
});