package org.vosao.dao;

import java.util.List;

import org.vosao.entity.FolderEntity;

public class FolderDaoTest extends AbstractDaoTest {

	private FolderEntity addFolder(final String name) {
		FolderEntity Folder = new FolderEntity(name);
		getDao().getFolderDao().save(Folder);
		return Folder;
	}
	
	public void testSave() {
		addFolder("test");
		List<FolderEntity> folders = getDao().getFolderDao().select();
		assertEquals(1, folders.size());
		FolderEntity folder1 = folders.get(0);
		assertEquals("test", folder1.getName());
	}	
	
	public void testGetById() {
		FolderEntity folder = addFolder("test");
		FolderEntity folder2 = getDao().getFolderDao().getById(folder.getId());
		assertEquals(folder.getName(), folder2.getName());
	}	
	
	public void testSelect() {
		addFolder("test1");
		addFolder("test2");
		addFolder("test3");
		List<FolderEntity> Folders = getDao().getFolderDao().select();
		assertEquals(3, Folders.size());
	}	
	
	public void testUpdate() {
		FolderEntity folder = addFolder("test");
		FolderEntity folder2 = getDao().getFolderDao().getById(folder.getId());
		folder2.setName("update");
		getDao().getFolderDao().save(folder2);
		FolderEntity folder3 = getDao().getFolderDao().getById(folder.getId());
		assertEquals("update", folder3.getName());
	}
	
	public void testResultList() {
		addFolder("test1");
		addFolder("test2");
		addFolder("test3");
		List<FolderEntity> list = getDao().getFolderDao().select();
		FolderEntity Folder = new FolderEntity("test4");
		list.add(Folder);
		assertEquals(4, list.size());
	}
	
}
