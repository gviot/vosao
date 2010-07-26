/**
 * Vosao CMS. Simple CMS for Google App Engine.
 * Copyright (C) 2009 Vosao development team
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * email: vosao.dev@gmail.com
 */

$(function() {
	$('#rootPage').click(function () { breadcrumbsEdit('/'); });
});

function breadcrumbsShow() {
	var path = pageParentUrl;
	if (editMode) {
		path = pageRequest.page.friendlyURL;
	}
	else {
		if (path == '/') {
			return;
		}
	}
	var h = '';
	var pages = path.substr(1).split('/');
	if (pages.length > 0) {
		var currentPath = ''; 
		$.each(pages, function(i,value) {
			currentPath += '/' + value;
			if (pages.length - 1 == i && editMode) {
				h += ' ' + pages[pages.length - 1];
			}
			else {
				h += ' <a href="#" onclick="breadcrumbsEdit(\'' 
					+ currentPath + '\')">' + value + '</a> /';
			}
		});
	}
	$('#crumbs').html(h);
}
	
function breadcrumbsEdit(path) {
	Vosao.jsonrpc.pageService.getPageByUrl(function(r) {
		location.href = '/cms/page/content.vm?id=' + r.id;
	}, path);
}	
