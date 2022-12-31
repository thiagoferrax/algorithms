package com.trainings.algorithms.strings;

public class CountLOC {
	private static final String AFTER_COMMENT_REMOVED = "After comment removed: ";
	private static final String COMMENT_REMOVED = "Comment removed: ";
	private static final String IS_THIS_AN_INLINE_COMMENT = "Is this an inline comment??";
	private static final String STARTING_A_MULTI_ROW_COMMENT = "Starting a multi-row comment??";
	private static final String FINISHING_MULTI_ROW_COMMENT = "Finishing multi-row comment?";
	private static final String MULTI_ROW_COMMENT = "Multi-row comment?";
	private static final String ONE_LINE_COMMENT = "One line comment!";
	private static final String MULTI_COMMENT_START = "/*";
	private static final String ONE_LINE_COMMENT_START = "//";
	private static final String MULTI_COMMENT_END = "*/";

	public static int count(String text) {        
	        String[] linesOfCode = text.split("\n");
			
	        int loc = linesOfCode.length;
	        
	        boolean multiRowComment = false;
	        for (String line : linesOfCode) {
	        	line = line.trim();
	        	
	        	line = removeInlineComments(line);

	        	if(line.length() == 0) {
	        		loc--;
	        	} else if(line.startsWith(ONE_LINE_COMMENT_START)) {
	        		System.out.println(ONE_LINE_COMMENT + line);		
	        		loc--;
	        	} else if(multiRowComment && !line.contains(MULTI_COMMENT_END)) {
	        		System.out.println(MULTI_ROW_COMMENT + line);	
	        		loc--;
	        	} if(multiRowComment && line.contains(MULTI_COMMENT_END)) {
	        		System.out.println(FINISHING_MULTI_ROW_COMMENT + line);	
	        		loc--;
	        		multiRowComment = false;
	        	} else if(!multiRowComment && line.startsWith(MULTI_COMMENT_START)) {
	        		System.out.println(STARTING_A_MULTI_ROW_COMMENT + line);	
	        		multiRowComment = true;
	        		loc--;
	        	} else {
	        		System.out.println(line);		
	        	}
	        	
			}
	        
	        return loc;
	  }

	private static String removeInlineComments(String line) {
		//Need a function to remove comments inside lines.
		if(line.contains(MULTI_COMMENT_START) && line.contains(MULTI_COMMENT_END)) {
			System.out.println(IS_THIS_AN_INLINE_COMMENT + line);	

			int start = line.indexOf(MULTI_COMMENT_START);
			int end = line.indexOf(MULTI_COMMENT_END);
			
			if(start < end) {
				System.out.println(COMMENT_REMOVED + line.substring(start, end+2));	
				String withoutInsideComment = line.substring(0, start) + line.substring(end+2, line.length());
				System.out.println(AFTER_COMMENT_REMOVED + withoutInsideComment);	
				
				return withoutInsideComment;
			}
		}
		
		return line;
	}
}
