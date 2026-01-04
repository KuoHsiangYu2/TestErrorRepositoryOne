package com.test;

public class StringFilter {
	
	public StringFilterVo doFilter(StringBuffer paramSb, String StartStr, String EndStr,int type,int panding) throws Exception {
		//System.out.println("====do UniFilter [" + StartStr + " ] to [ " + EndStr + "] Start==== ");
		StringFilterVo vo = new StringFilterVo();
		
		StringBuffer tmpSb = new StringBuffer();
		StringBuffer rtnSb = new StringBuffer();
		boolean tagStart = false;
		boolean tagEnd = false;
		int tagStartIdx = 0;
		int tagEndIdx = 0;
		char[] StartStrArr = StartStr.toCharArray();
		char[] EndStrArr = EndStr.toCharArray();
		

		
		for (int i = 0; i < paramSb.length(); i++) {
			char tmpChar = paramSb.charAt(i);
			tmpSb.append(tmpChar);

			if (tmpChar == StartStrArr[0]) {
				// 長度檢查
				if (i + StartStrArr.length > paramSb.length()) {
					continue;
				}
				
				String tmpStr = paramSb.substring(i, i + StartStrArr.length);
				if (StartStr.equals(tmpStr)) {
					tagStartIdx = tmpSb.length() - 1;
					tagStart = true;
				}
			}

			if (tmpChar == EndStrArr[EndStrArr.length - 1] && tagStart) {
				String tmpStr = paramSb.substring(i - EndStrArr.length + 1, i + 1);
				if (EndStr.equals(tmpStr)) {
					tagEndIdx = tmpSb.length() - 1;
					tagEnd = true;
				}
			}

			if (tagStart && tagEnd) {
				tagStart = false;
				tagEnd = false;
				
				if (type == 1) {
					tagStartIdx = panding + tagStartIdx;
					rtnSb.append(tmpSb.substring(tagStartIdx , tagEndIdx));
				} else if (type == 2) {
					tagEndIdx = tagEndIdx + panding;
					rtnSb.append(tmpSb.substring(tagStartIdx , tagEndIdx));
				} else {
					rtnSb.append(tmpSb.substring(tagStartIdx , tagEndIdx));
				}

				
				break;
			}
		}
		//System.out.println("====do UniFilter [" + StartStr + " ] to [ " + EndStr + "] End==== ");
		vo.setTagStartIdx(tagStartIdx);
		vo.setTagEndIdx(tagEndIdx);
		vo.setFilterStr(rtnSb.toString());
		return vo;
	}
}
