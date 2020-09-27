package com.putandpost.quicktour.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.putandpost.quicktour.dto.NewPackage;
import com.putandpost.quicktour.dto.PackageInfo;
import com.putandpost.quicktour.util.InMemoryDatabase;

@Path("/tour")
public class QuickTour {

	InMemoryDatabase inMemoryDatabase = null;

	public QuickTour() {
		inMemoryDatabase = InMemoryDatabase.getInstance();
		System.out.println("In Memory Database Created  :: "+inMemoryDatabase.hashCode());
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public StreamingOutput newPackage(InputStream inputStream) {
		PackageInfo packageInfo = new PackageInfo();
		NewPackage userPackage = null;
		try {
			userPackage = readRequestBody(inputStream);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		packageInfo.setPackageName(userPackage.getPackageName());
		packageInfo.setOrderNo(UUID.randomUUID().toString());
		packageInfo.setAmount(6857.837);
		packageInfo.setPerson(userPackage.getPersonName());
		packageInfo.setStatus("Confirm..");
		packageInfo.setComments("Your request has been proccessed....");
		inMemoryDatabase.storePackage(packageInfo.getOrderNo(), packageInfo);

		return new PackageInfoStreamWriter(packageInfo);
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getPackages(@QueryParam("order-no") String orderNo) {
		return new PackageInfoStreamWriter(inMemoryDatabase.getPackage(orderNo));
	}

	private NewPackage readRequestBody(InputStream is) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory builderFactory = null;
		DocumentBuilder builder = null;
		Document document = null;
		NewPackage newPackage = null;

		builderFactory = DocumentBuilderFactory.newInstance();
		builder = builderFactory.newDocumentBuilder();
		document = builder.parse(is);

		newPackage = new NewPackage();

		Node rootElement = document.getFirstChild();
		System.out.println(rootElement.getNodeName());
		NodeList childElements = rootElement.getChildNodes();
		for (int i = 0; i < childElements.getLength(); i++) {
			Node childNode = childElements.item(i);
			String name = childNode.getNodeName();
			System.out.println(name);
			
			if ("package-name".equals(name)) {
				newPackage.setPackageName(childNode.getTextContent());
				System.out.println(childNode.getTextContent());
			} else if ("person-name".equals(name)) {
				newPackage.setPersonName(childNode.getTextContent());
			} else if ("mobile-no".equals(name)) {
				newPackage.setMobileNo(childNode.getTextContent());
			} else if ("email-address".equals(name)) {
				newPackage.setEmailAddress(childNode.getTextContent());
			}
		}
		return newPackage;
	}

	private class PackageInfoStreamWriter implements StreamingOutput {

		PackageInfo packageInfo = null;

		public PackageInfoStreamWriter(PackageInfo packageInfo) {
			this.packageInfo = packageInfo;
		}

		@Override
		public void write(OutputStream os) throws IOException, WebApplicationException {

			StringBuffer stringBuffer = null;
			stringBuffer = new StringBuffer();
			stringBuffer.append("<package-info>").append("<order-no>").append(packageInfo.getOrderNo())
					.append("</order-no>").append("<person-name>").append(packageInfo.getPerson())
					.append("</person-name>").append("<package-name>").append(packageInfo.getPackageName())
					.append("</package-name>").append("<amount>").append(packageInfo.getAmount()).append("</amount>")
					.append("<status>").append(packageInfo.getStatus()).append("</status>").append("<comment>")
					.append(packageInfo.getComments()).append("</comment>").append("</package-info>");

			os.write(stringBuffer.toString().getBytes());
			os.close();
		}
	}
}
