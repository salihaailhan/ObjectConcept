package com.pool;

public class TestCase {

	public static void main(String[] args) {
		
		System.out.println("*********************************************************");
		System.out.println("// SIMPLE POOL OBJECT BEGIN");
		System.out.println("=========================================================");
		
		System.out.println("*********************************************************");
		System.out.println("// SimpleObjectPoolManager sObjPoolMng = new SimpleObjectPoolManager();");
		System.out.println("=========================================================");
		SimpleObjectPoolManager sObjPoolMng = new SimpleObjectPoolManager();
		
		System.out.println("*********************************************************");
		System.out.println("// SimplePoolObject sPoolObj1 = sObjPoolMng.getObjectFromPool();");
		System.out.println("// SimplePoolObject sPoolObj2 = sObjPoolMng.getObjectFromPool();");
		System.out.println("// SimplePoolObject sPoolObj3 = sObjPoolMng.getObjectFromPool();");
		System.out.println("=========================================================");
		SimplePoolObject sPoolObj1 = sObjPoolMng.getObjectFromPool();
		SimplePoolObject sPoolObj2 = sObjPoolMng.getObjectFromPool();
		SimplePoolObject sPoolObj3 = sObjPoolMng.getObjectFromPool();
		
		System.out.println("*********************************************************");
		System.out.println("// System.out.println(sPoolObj1);");
		System.out.println("// System.out.println(sPoolObj2);");
		System.out.println("// System.out.println(sPoolObj3);");
		System.out.println("=========================================================");
		System.out.println(sPoolObj1);
		System.out.println(sPoolObj2);
		System.out.println(sPoolObj3);
		
		System.out.println("*********************************************************");
		System.out.println("// sObjPoolMng.returnObjectToPool(sPoolObj2);");
		System.out.println("=========================================================");
		sObjPoolMng.returnObjectToPool(sPoolObj2);
		
		System.out.println("*********************************************************");
		System.out.println("// SimplePoolObject sPoolObj4 = sObjPoolMng.getObjectFromPool();");
		System.out.println("=========================================================");
		SimplePoolObject sPoolObj4 = sObjPoolMng.getObjectFromPool();
		
		System.out.println("*********************************************************");
		System.out.println("// System.out.println(sPoolObj4);");
		System.out.println("=========================================================");
		System.out.println(sPoolObj4);
		
		System.out.println("*********************************************************");
		System.out.println("// SIMPLE POOL OBJECT END");
		System.out.println("=========================================================");
		
		System.out.println("*********************************************************");
		System.out.println("// IMPROVED POOL OBJECT BEGIN");
		System.out.println("=========================================================");

		String connectionString = "Server=AYBU;Database=STD_DB;User Id=usr1;Password=pwd1";
		int initialPoolSize = 5;
		int maximumPoolSize = 10;
		ImprovedConnectionPoolManager connectionPool = new ImprovedConnectionPoolManager(connectionString, initialPoolSize, maximumPoolSize);
		System.out.println();
		
		System.out.println("Available connection count = " + connectionPool.getAvailableConnectionCount());
		System.out.println("In-use connection count = " + connectionPool.getInUseConnectionCount());
		System.out.println();	
		
		ImprovedConnection o1 = connectionPool.getObjectFromPool();
		ImprovedConnection o2 = connectionPool.getObjectFromPool();
		ImprovedConnection o3 = connectionPool.getObjectFromPool();
		
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		
		System.out.println("Available connection count = " + connectionPool.getAvailableConnectionCount());
		System.out.println("In-use connection count = " + connectionPool.getInUseConnectionCount());
		System.out.println();	
		
		System.out.println(o1 + "that is returned to the pool.");
		System.out.println(o2 + "that is returned to the pool.");
		o1.close();		// return connection to the pool		
		o2.close();		// return connection to the pool		

		System.out.println("Available connection count = " + connectionPool.getAvailableConnectionCount());
		System.out.println("In-use connection count = " + connectionPool.getInUseConnectionCount());
		System.out.println();	
		
		ImprovedConnection o4 = connectionPool.getObjectFromPool();
		ImprovedConnection o5 = connectionPool.getObjectFromPool();
		ImprovedConnection o6 = connectionPool.getObjectFromPool();
		ImprovedConnection o7 = connectionPool.getObjectFromPool();
		ImprovedConnection o8 = connectionPool.getObjectFromPool();
		ImprovedConnection o9 = connectionPool.getObjectFromPool();

		System.out.println("Available connection count = " + connectionPool.getAvailableConnectionCount());
		System.out.println("In-use connection count = " + connectionPool.getInUseConnectionCount());
		System.out.println();	
		
		System.out.println(o4);
		System.out.println(o5);
		System.out.println(o6);
		System.out.println(o7);
		System.out.println(o8);
		System.out.println(o9);
		System.out.println();
	
		System.out.println("Available connection count = " + connectionPool.getAvailableConnectionCount());
		System.out.println("In-use connection count = " + connectionPool.getInUseConnectionCount());
		System.out.println();	
		
		System.out.println(o6 + "that is returned to the pool.");
		System.out.println(o7 + "that is returned to the pool.");
		o6.close();		// return connection to the pool		
		o7.close();		// return connection to the pool		
		
		System.out.println("Available connection count = " + connectionPool.getAvailableConnectionCount());
		System.out.println("In-use connection count = " + connectionPool.getInUseConnectionCount());
		System.out.println();	
		
		connectionPool.finalizePool();		
		
		System.out.println("*********************************************************");
		System.out.println("// IMPROVED POOL OBJECT END");
		System.out.println("=========================================================");
		
	}

}
