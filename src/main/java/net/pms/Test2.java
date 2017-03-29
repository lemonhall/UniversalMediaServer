package net.pms;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import net.pms.io.iokit.IOKit;
import net.pms.io.iokit.IOReturn;
import net.pms.util.jna.CFTypeArrayRef;
import net.pms.util.jna.CoreFoundation;
import net.pms.util.jna.PointerArrayByReference;
import net.pms.util.jna.StringByReference;
import net.pms.util.jna.TerminatedStringEncodingArray;
import net.pms.util.jna.UTF16StringByReference;
import net.pms.util.jna.WStringByReference;
import net.pms.util.jna.CoreFoundation.CFArrayRef;
import net.pms.util.jna.CoreFoundation.CFComparisonResult;
import net.pms.util.jna.CoreFoundation.CFDataRef;
import net.pms.util.jna.CoreFoundation.CFDictionaryRef;
import net.pms.util.jna.CoreFoundation.CFMutableArrayRef;
import net.pms.util.jna.CoreFoundation.CFMutableDataRef;
import net.pms.util.jna.CoreFoundation.CFMutableDictionaryRef;
import net.pms.util.jna.CoreFoundation.CFMutableStringRef;
import net.pms.util.jna.CoreFoundation.CFNumberRef;
import net.pms.util.jna.CoreFoundation.CFNumberType;
import net.pms.util.jna.CoreFoundation.CFStringBuiltInEncodings;
import net.pms.util.jna.CoreFoundation.CFStringCompareFlags;
import net.pms.util.jna.CoreFoundation.CFStringRef;
import net.pms.util.jna.CoreFoundation.CFTypeRef;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//com.sun.jna.platform.mac.XAttrUtil
		//System.out.print(JnaTest.getInstance().hasTrash() ? "Yes" : "Nope");
		//System.out.print(FileManager.INSTANCE.FSPathMakeRef("", 0, new ByteByReference((byte) 1)));
		Native.setProtected(true);
		CoreFoundation coreFoundation = CoreFoundation.INSTANCE;
		IntByReference assertionID = new IntByReference();
		CFStringRef assertionType = CFStringRef.toCFStringRef(IOKit.kIOPMAssertPreventUserIdleSystemSleep);
		CFStringRef name = CFStringRef.toCFStringRef("TestName");
		IOReturn ioReturn = IOKit.INSTANCE.IOPMAssertionCreateWithName(assertionType, IOKit.kIOPMAssertionLevelOn, name, assertionID);
		System.out.println(ioReturn);
		System.out.println(Integer.toHexString(ioReturn.getValue()));
		System.out.println(assertionID.getValue());
		CFStringRef details = CFStringRef.toCFStringRef("Testing out IOKit");
		CFStringRef timeOutAction = CFStringRef.toCFStringRef(IOKit.kIOPMAssertionTimeoutActionTurnOff);
		IOReturn ioResult = IOKit.INSTANCE.IOPMAssertionCreateWithDescription(assertionType, name, details, null, null, 10d, timeOutAction, assertionID);
		System.out.println(ioResult);
		System.out.println(Integer.toHexString(ioResult.getValue()));
		System.out.println(assertionID.getValue());
		CFDictionaryRef dict =
		IOKit.INSTANCE.IOPMAssertionCopyProperties(assertionID.getValue());
		CFStringRef key = CFStringRef.toCFStringRef(IOKit.kIOPMAssertionTimeoutActionKey);
		CFStringRef value = new CFStringRef(coreFoundation.CFDictionaryGetValue(dict, key));
		System.out.println(value);
		CFMutableDictionaryRef mutableDict = coreFoundation.CFDictionaryCreateMutableCopy(null, 0, dict);
		CFMutableDictionaryRef emptyMutableDict = coreFoundation.CFDictionaryCreateMutable(null, 20, null, null);
		CFNumberRef someInt = CFNumberRef.toCFNumberRef(5);
		CFStringRef someText = CFStringRef.toCFStringRef("My added string");
		coreFoundation.CFDictionaryAddValue(mutableDict, someInt, someText);
		long dictSize = coreFoundation.CFDictionaryGetCount(mutableDict);
		CFTypeArrayRef keys = new CFTypeArrayRef(dictSize);
		CFTypeArrayRef values = new CFTypeArrayRef(dictSize);
		coreFoundation.CFDictionaryGetKeysAndValues(mutableDict, keys, values);
		CFTypeRef[] refArray = keys.getArray();
		System.out.println(refArray.toString());
		PointerByReference pointerRef = new PointerByReference();
		boolean bo = coreFoundation.CFDictionaryGetValueIfPresent(dict, key, pointerRef);
		CFTypeRef typeRef = new CFTypeRef(pointerRef.getValue());
		//coreFoundation.CFDictionaryRemoveValue(mutableDict, key);
		//coreFoundation.CFDictionaryRemoveAllValues(mutableDict);
		//coreFoundation.CFDictionaryReplaceValue(mutableDict, key, someText);
		coreFoundation.CFDictionarySetValue(mutableDict, key, someText);
		coreFoundation.CFDictionarySetValue(emptyMutableDict, key, someText);
		bo = coreFoundation.CFDictionaryGetValueIfPresent(emptyMutableDict, key, pointerRef);
		typeRef = new CFTypeRef(pointerRef.getValue());
		coreFoundation.CFRelease(key);
		key = CFStringRef.toCFStringRef("testkey");
		coreFoundation.CFDictionaryAddValue(emptyMutableDict, key, someText);
		long l = coreFoundation.CFDictionaryGetCountOfValue(emptyMutableDict, value);
		l = coreFoundation.CFDictionaryGetCountOfValue(emptyMutableDict, someText);
		Pointer test = coreFoundation.kCFTypeArrayCallBacks;
		CFTypeRef[] typeRefs = new CFTypeRef[4];
		typeRefs[0] = CFStringRef.toCFStringRef("First array element");
		typeRefs[1] = CFStringRef.toCFStringRef("Second array element");
		typeRefs[2] = CFStringRef.toCFStringRef("Third array element");
		typeRefs[3] = CFStringRef.toCFStringRef("Fourth array element");		
		CFTypeArrayRef arrayRef = new CFTypeArrayRef(typeRefs);
		
		CFArrayRef cfArray = coreFoundation.CFArrayCreate(null, arrayRef, 4, CoreFoundation.kCFTypeArrayCallBacks);
		coreFoundation.CFArrayGetCount(cfArray);
		coreFoundation.CFArrayGetValueAtIndex(cfArray, 3);
		CFArrayRef cfArray2 = coreFoundation.CFArrayCreateCopy(null, cfArray);
		CFMutableArrayRef emptyCfArray = coreFoundation.CFArrayCreateMutable(null, 0, CoreFoundation.kCFTypeArrayCallBacks);
		CFMutableArrayRef cfArray3 = coreFoundation.CFArrayCreateMutableCopy(null, 5, cfArray2);
		coreFoundation.CFArrayExchangeValuesAtIndices(cfArray3, 0, 3);
		coreFoundation.CFArrayAppendValue(cfArray3, someText);
		coreFoundation.CFArrayAppendValue(emptyCfArray, someText);
		coreFoundation.CFArrayInsertValueAtIndex(cfArray3, 1, details);
		coreFoundation.CFArraySetValueAtIndex(cfArray3, 3, name);
		coreFoundation.CFArrayRemoveValueAtIndex(cfArray3, 2);
		coreFoundation.CFArrayRemoveAllValues(cfArray3);
		
		byte[] bytes = "Test bytes foreva".getBytes();
		CFDataRef cfData = coreFoundation.CFDataCreate(null, bytes, bytes.length);
		CFDataRef cfData2 = coreFoundation.CFDataCreateCopy(null, cfData);
		CFMutableDataRef cfData3 = coreFoundation.CFDataCreateMutableCopy(null, 0, cfData2);
		CFMutableDataRef emptyCfData = coreFoundation.CFDataCreateMutable(null, 52);
		PointerByReference pointerRef2 = new PointerByReference();
		pointerRef2 = coreFoundation.CFDataGetBytePtr(cfData);
		pointerRef2.getPointer().getByteArray(0, 17);
		pointerRef2 = coreFoundation.CFDataGetMutableBytePtr(cfData3);
		coreFoundation.CFDataIncreaseLength(emptyCfData, 20);
		byte[] bytes2 = "More testbytes".getBytes();
		coreFoundation.CFDataAppendBytes(cfData3, bytes2, bytes2.length);
		
		/*CFNumberRef i = CFNumberRef.toCFNumber(43.8f);
		System.out.println(i);
		coreFoundation.CFRelease(i);*/
		coreFoundation.CFNullGetTypeID();
		CFStringRef cfString = CFStringRef.toCFStringRef("Test 𐘺𐝀 stringøæåß づ");
		CFNumberRef cfInteger = CFNumberRef.toCFNumberRef(110);
		CFNumberRef cfDouble = CFNumberRef.toCFNumberRef(93.8);
		IntByReference refInt = new IntByReference();
		coreFoundation.CFNumberGetValue(cfInteger, CFNumberType.kCFNumberSInt32Type, refInt);
		refInt.getValue();
		DoubleByReference refDouble = new DoubleByReference();
		coreFoundation.CFNumberGetValue(cfDouble, CFNumberType.kCFNumberFloat64Type, refDouble);
		refDouble.getValue();
		coreFoundation.CFNumberGetValue(cfDouble, CFNumberType.kCFNumberSInt32Type, refInt);
		StringByReference refString = new StringByReference("Test reference string");
		CFStringRef cfString2 = coreFoundation.CFStringCreateWithCString(null, "Test string 2", CFStringBuiltInEncodings.kCFStringEncodingWindowsLatin1.getValue());
		byte[] stringBytes = "Test byte array string".getBytes(StandardCharsets.UTF_16BE);
		CFStringRef cfString3 = coreFoundation.CFStringCreateWithBytes(null, stringBytes, stringBytes.length, CFStringBuiltInEncodings.kCFStringEncodingUTF16BE.getValue(), false);
		CFMutableStringRef mutableString = coreFoundation.CFStringCreateMutable(null, 20);
		refString = new StringByReference(20);
		boolean b = coreFoundation.CFStringGetCString(cfString2, refString, refString.getAllocatedSize(), CFStringBuiltInEncodings.kCFStringEncodingISOLatin1.getValue());
		refString = coreFoundation.CFStringGetCStringPtr(cfString, CFStringBuiltInEncodings.kCFStringEncodingMacRoman.getValue());
		//char[] chars = coreFoundation.CFStringGetCharactersPtr(cfString);
		UTF16StringByReference chars = coreFoundation.CFStringGetCharactersPtr(cfString);
		chars.getValue();
		System.out.println(chars.toString());
		chars.setValue("Jule n𐝃ssen jeß ¢");
		System.out.println(chars.toString());
		coreFoundation.CFStringGetSmallestEncoding(cfString);
		coreFoundation.CFStringGetFastestEncoding(cfString);
		coreFoundation.CFStringGetMaximumSizeOfFileSystemRepresentation(cfString);
		refString = new StringByReference(40);
		b = coreFoundation.CFStringGetFileSystemRepresentation(cfString, refString, 40);
		CFStringRef cfString4 = coreFoundation.CFStringCreateWithFileSystemRepresentation(null, refString);
		CFComparisonResult cRes = coreFoundation.CFStringCompare(cfString4, cfString, CFStringCompareFlags.kCFCompareCaseInsensitive.getValue());
		coreFoundation.CFStringIsEncodingAvailable(CFStringBuiltInEncodings.kCFStringEncodingNonLossyASCII.getValue());
		TerminatedStringEncodingArray encoding = coreFoundation.CFStringGetListOfAvailableEncodings();
		encoding.size();
		encoding = new TerminatedStringEncodingArray(Arrays.asList(new Integer[]{Integer.valueOf(5), Integer.valueOf(-3), Integer.valueOf(9), Integer.valueOf(100)}));
		encoding.size();
		encoding = new TerminatedStringEncodingArray();
		encoding.size();
	}

}

