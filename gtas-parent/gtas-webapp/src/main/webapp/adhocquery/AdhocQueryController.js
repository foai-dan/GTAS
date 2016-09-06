/*
 * All GTAS code is Copyright 2016, Unisys Corporation.
 * 
 * Please see LICENSE.txt for details.
 */
app.controller('AdhocQueryCtrl', function ($scope, adhocQueryService) {
    'use strict;'
	//init
	
	$scope.pageSize = 10;
	$scope.pageNumber = 1;

    $scope.resultsGrid = {
    	paginationPageSizes: [10, 15, 25],
        paginationPageSize: $scope.pageSize,
        paginationCurrentPage: $scope.pageNumber,
        useExternalPagination: true,
        useExternalSorting: true,
        useExternalFiltering: true,
        enableHorizontalScrollbar: 0,
        enableVerticalScrollbar: 1,
        enableColumnMenus: false,
        multiSelect: false,
        minRowsToShow: 10,
        enableExpandableRowHeader: false,
        expandableRowTemplate: '<div ui-grid="row.entity.subGridOptions"></div>',        

        onRegisterApi: function (gridApi) {
            $scope.gridApi = gridApi;
            
            gridApi.pagination.on.paginationChanged($scope, function (newPage, pageSize) {
                $scope.pageNumber = newPage;
                $scope.pageSize = pageSize;
                $scope.searchPax($scope.query, newPage, pageSize);
            });
        }
    };

    $scope.resultsGrid.columnDefs = [
        {
            field: 'lastName',
            name: 'lastName',
            displayName: 'pass.lastname', headerCellFilter: 'translate',
            cellTemplate: '<md-button aria-label="type" href="#/paxdetail/{{row.entity.id}}/{{row.entity.flightId}}" title="Launch Flight Passengers in new window" target="pax.detail.{{row.entity.passengerId}}.{{row.entity.flightId}}" class="md-primary md-button md-default-theme" >{{COL_FIELD}}</md-button>'
        },
        {
            field: 'firstName',
            name: 'firstName',
            displayName: 'pass.firstname', headerCellFilter: 'translate'
        },
        {
            field: 'middleName',
            name: 'middleName',
            displayName: 'pass.middlename', headerCellFilter: 'translate'
        },
        {
            field: 'flightNumber',
            name: 'flightNumber',
            displayName: 'pass.flight', headerCellFilter: 'translate',
            cellTemplate: '<div>{{row.entity.carrier}}{{COL_FIELD}}</div>'
        }
    ];
    
    //For button press.
    $scope.initSearchPax = function(){
    	$scope.searchPax($scope.query, 1, 10);
    }
    
    $scope.searchPax = function (query, pageNumber, pageSize) {
        return adhocQueryService.getPassengers(query, pageNumber, pageSize).then(function (response) {
            console.log(response.data.result);
            $scope.resultsGrid.data = response.data.result.passengers;
            $scope.resultsGrid.totalItems = response.data.result.totalhits;
        });
    }
});
