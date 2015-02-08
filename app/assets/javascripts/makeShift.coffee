$ ->
	# 交代制変更時
	$('input[name=shiftSystem]').change ->
		showShiftDetail($(this).val())
	@	

	# シフト表イメージの各セルクリック時、オンオフを切り替える
	$('td.calendar-cell').click ->
		switchHoliday(this)
	@

	# メンバーの行を追加する
	$('.add-member').click ->
		# コピーする行を取得
		lastEmployee = $('.employees tr:last-child')
		# 新しい行のindexを作成
		oldIndex = parseInt(lastEmployee.attr('class').match(/[0-9]/)) 
		newIndex = oldIndex + 1
		# 行のクラス名のindexを付与する
		newRowClassName = 'employee_'+newIndex
		newEmployee = lastEmployee.clone(true).attr('class',newRowClassName)
		# 新しい行を追加する
		(newEmployee).appendTo('.employees')
		$(".#{newRowClassName} input[name='employees[#{oldIndex}].name']")
			.attr('id',"employees_#{newIndex}_name")
			.attr('name',"employees[#{newIndex}].name")
		
		
	@

@

# 交代制詳細部の表示制御
showShiftDetail = (display) ->
	if parseBool(display)
		$('#shiftDetail').show()
	else
		$('#shiftDetail').hide()
		
# シフト表イメージの各セルクリック時、オンオフを切り替える
switchHoliday = (obj) ->	
	# 希望休チェックボックスのオンオフに応じて処理を切り替える
	check = $(obj).find("input[type=checkbox]")
	if check.prop('checked')
		$(obj).find('.holiday_symbol').css("visibility","hidden")	# "休"マークを削除
		$(obj).removeClass("holiday")								# クラスを削除
		check.prop("checked",false)									# チェックボックスをオフにする
	else
		$(obj).find('.holiday_symbol').css("visibility","visible")	# "休"マークを表示
		$(obj).addClass("holiday")									# クラスを削除
		check.prop("checked",true)									# チェックボックスをオンにする

parseBool = (value) ->
	if /^(true|on|yes|1)$/.test(value)
		true
	else if /^(false|off|no|0)$/.test(value)
		false