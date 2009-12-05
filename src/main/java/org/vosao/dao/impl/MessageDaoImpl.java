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

package org.vosao.dao.impl;

import java.util.List;

import org.vosao.dao.MessageDao;
import org.vosao.entity.MessageEntity;

public class MessageDaoImpl extends BaseDaoImpl<String, MessageEntity> 
		implements MessageDao {

	public MessageDaoImpl() {
		super(MessageEntity.class);
	}

	@Override
	public List<MessageEntity> selectByCode(final String code) {
		String query = "select from " + MessageEntity.class.getName()
				+ " where code == pCode"
				+ " parameters String pCode";
		return select(query, params(code));
	}
	
	@Override
	public MessageEntity getByCode(final String code, 
			final String languageCode) {
		String query = "select from " + MessageEntity.class.getName() 
					+ " where code == pCode && languageCode == pLanguageCode" 
					+ " parameters String pCode, String pLanguageCode";
		return selectOne(query, params(code, languageCode));
	}

	@Override
	public List<MessageEntity> select(final String languageCode) {
		String query = "select from " + MessageEntity.class.getName()
				+ " where languageCode == pLanguageCode"
				+ " parameters String pLanguageCode";
		return select(query, params(languageCode));
	}

}
