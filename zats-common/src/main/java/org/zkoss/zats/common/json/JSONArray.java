/*
 *    Copyright 2011 JSON-SMART authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zkoss.zats.common.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A JSON array. JSONObject supports java.util.List interface.
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 * @author Uriel Chemouni <uchemouni@gmail.com>
 * @since 1.1.0
 */
public class JSONArray extends ArrayList<Object> implements List<Object> {
	private static final long serialVersionUID = 9106884089231309568L;

	/**
	 * Convert a list to JSON text. The result is a JSON array. If this list is
	 * also a JSONAware, JSONAware specific behaviours will be omitted at this
	 * top level.
	 * 
	 * @see org.zkoss.zats.common.json.JSONValue#toJSONString(Object)
	 * 
	 * @return JSON text, or "null" if list is null.
	 */
	public static String toJSONString(List<Object> list) {
		StringBuilder sb = new StringBuilder();
		try {
			writeJSONString(list, sb);
		} catch (IOException e) {
			// Can not append on a string builder
		}
		return sb.toString();
	}

	/**
	 * Encode a list into JSON text and write it to out. If this list is also a
	 * JSONStreamAware or a JSONAware, JSONStreamAware and JSONAware specific
	 * behaviours will be ignored at this top level.
	 * 
	 * @see org.zkoss.zats.common.json.JSONValue#writeJSONString(Object, Appendable)
	 */
	public static void writeJSONString(List<Object> list, Appendable out) throws IOException {
		if (list == null) {
			out.append("null");
			return;
		}

		boolean first = true;
		out.append('[');
		for (Object value : list) {
			if (first)
				first = false;
			else
				out.append(',');
			if (value == null)
				out.append("null");
			else
				JSONValue.writeJSONString(value, out);
		}
		out.append(']');
	}

	public void merge(Object o2) {
		JSONObject.merge(this, o2);
	}

	/**
	 * Explicitely Serialize Object as JSon String
	 */
	public String toJSONString() {
		return toJSONString(this);
	}

	/**
	 * Override natif toStirng()
	 */
	public String toString() {
		return toJSONString();
	}

	public void writeJSONString(Appendable out) throws IOException {
		writeJSONString(this, out);
	}
}
