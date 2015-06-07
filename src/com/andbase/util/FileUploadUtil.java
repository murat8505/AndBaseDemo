/*
import java.io.File;
	private Map fileField = new TreeMap(); 
	private Map formField = new TreeMap(); 
	private int memoryBlock = 2048; 
	private File saveFolder = null; 
	private boolean multipart = false; 
	private HttpServletRequest request = null; 
	private final int maxSize = Constant.UPLOAD_MAX_FILESIZE; 
	
		this.saveFolder = saveFolder;
	
	}
	public HashMap<String,String> download(HttpServletRequest request, String charset) throws FileUploadException {
		this.request = request;
		multipart = FileUpload.isMultipartContent(request);
		if (multipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(memoryBlock);
			factory.setRepository(saveFolder);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxSize);
			List items = upload.parseRequest(request);
			Iterator iterator = items.iterator();
			while (iterator.hasNext()) {
				FileItem item = (FileItem) iterator.next();
				if (item.isFormField()) {
					processFormField(item, charset);
				} else {
					processUploadedFile(item);
				}
			}
		}
	}
	private void processFormField(FileItem item, String charset) {
		try {
			String name = item.getFieldName();
			String value = item.getString(charset);
			Object objv = formField.get(name);
			if (objv == null) {
				formField.put(name, value);
			} else {
				List values = null;
				if (objv instanceof List) {
					values = (List) objv;
					values.add(value);
				} else {
					String strv = (String) objv;
					values = new ArrayList();
					values.add(strv);
					values.add(value);
				}
				formField.put(name, values);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("the argument \"charset\" missing!");
		}
	}
	private String processUploadedFile(FileItem item) {
		String fieldName = item.getFieldName();
		fileField.put(fieldName, item);
	}
	public static String write2file(FileItem item, File file) {
		try {
			item.write(file);
		} catch (Exception e) {
		}
		return null;
	}
	public FileItem getFileItem(String fieldName) {
		if (multipart) {
			return (FileItem) fileField.get(fieldName);
		} else {
			return null;
		}
	}
	public String getParameter(String fieldName) {
		String value = null;
		if (multipart) {
			Object obj = formField.get(fieldName);
			if (obj != null && obj instanceof String) {
				value = (String) obj;
			}
		} else if (request != null) {
			value = request.getParameter(fieldName);
		}
		return value;
	}
	public String[] getParameterValues(String fieldName) {
		String[] values = null;
		if (multipart) {
			Object obj = formField.get(fieldName);
			if (obj != null) {
				if (obj instanceof List) {
					values = (String[]) ((List) obj).toArray(new String[0]);
				} else {
					values = new String[] {(String) obj};
				}
			}
		} else if (request != null) {
			values = request.getParameterValues(fieldName);
		}
		return values;
	}
	public File getRepository() {
		return this.saveFolder;
	}
	public int getSizeThreshold() {
		return this.memoryBlock;
	}
	public boolean isMultipart() {
		return this.multipart;
	}
	public int getMaxSize() {
		return maxSize;
	}
}*/